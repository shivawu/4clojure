; 140. Veitch, Pleases!
(fn [clauses]
  (let [norm-var (fn [sym]
                   (let [s (str sym)]
                     (mapv symbol [(.toUpperCase s) (.toLowerCase s)])))
        vars (set (map norm-var (reduce clojure.set/union clauses)))
        gray-code (fn self [vars]
                    (if (empty? vars) (list nil)
                      (let [[p n] (first vars)
                            r (self (rest vars))]
                        (concat (map #(cons n %) r) (map #(cons p %) (reverse r))))))
        eval-cnf (fn [cnf assigns]
                   (true? (some #(clojure.set/subset? % assigns) cnf)))
        karnaugh-map (fn [vars cnf]
                       (let [n (count vars)
                             [rows cols] (map gray-code (split-at (quot n 2) vars))]
                         {:rows (vec rows),
                          :cols (vec cols),
                          :map (mapv (fn [r]
                                       (mapv (fn [c]
                                               (eval-cnf clauses (-> #{} (into r) (into c))))
                                         cols))
                                 rows)}))
        minterms (fn [{rows :rows, cols :cols, kmap :map}]
                   (let [n (count kmap)
                         m (count (kmap 0))
                         partial-sum (let [get (fn [x y]
                                                 (get-in kmap [(mod x n) (mod y m)]))
                                           sum (let [f (fn [self x y]
                                                         (if (or (zero? x) (zero? y))
                                                           0
                                                           (+
                                                             (if (get (dec x) (dec y)) 1 0)
                                                             (self self x (dec y))
                                                             (self self (dec x) y)
                                                             (- (self self (dec x) (dec y))))))
                                                     mf (memoize f)]
                                                 (partial mf mf))]
                                       (fn [x y xl yl]
                                         (let [x2 (+ x xl)
                                               y2 (+ y yl)]
                                           (-
                                             (+ (sum x2 y2) (sum x y))
                                             (+ (sum x y2) (sum x2 y))))))
                         terms (for [x (range n)
                                     y (range m)
                                     xl (take-while #(<= % n) (iterate #(+ % %) 1))
                                     yl (take-while #(<= % m) (iterate #(+ % %) 1))
                                     :when (= (* xl yl) (partial-sum x y xl yl))]
                                 [x y xl yl])
                         notcovered (remove (fn [[x1 y1 xl1 yl1 :as t1]]
                                              (some (fn [[x2 y2 xl2 yl2 :as t2]]
                                                      (and (not= t1 t2)
                                                        (<= x2 x1) (<= y2 y1)
                                                        (>= (+ x2 xl2) (+ x1 xl1)) (>= (+ y2 yl2) (+ y1 yl1)))) terms)) terms)
                         get-assigns (fn [[x y xl yl]]
                                       (let [get #(set (%1 (mod %2 (count %1))))]
                                         (clojure.set/union
                                           (reduce clojure.set/intersection (for [a (range xl)] (get rows (+ x a))))
                                           (reduce clojure.set/intersection (for [b (range yl)] (get cols (+ y b)))))))
                         terms (for [[asn [[x y xl yl] & _]] (group-by get-assigns notcovered)]
                                 [asn (set
                                        (for [a (range xl) b (range yl)]
                                          [(mod (+ x a) n) (mod (+ y b) m)]))])
                         search (let [num1 (apply + (map #(count (filter true? %)) kmap))]
                                  (fn search [taken maxd covered]
                                    (cond
                                      (< maxd (count taken)) nil
                                      (= num1 (count covered)) taken
                                      :else (first (remove nil?
                                                     (for [[asn ones] terms
                                                           :when (not (taken asn))]
                                                       (search (conj taken asn) maxd (into covered ones))))))))]
                     (first (remove nil?
                              (for [d (range 1 (inc (count terms)))]
                                (search #{} d #{}))))))]
    (minterms (karnaugh-map vars clauses))))

