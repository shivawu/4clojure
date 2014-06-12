; 152. Latin Square Slicing
(fn [vs]
  (let [n (count vs)
        m (apply max (map count vs))
        latin? (fn [v]
                 (let [s (set (v 0))]
                   (and
                     (= (count s) (count v))
                     (every? #(= s %) (map set v))
                     (every? #(= s %) (map set (apply mapv vector v))))))]
    (into {}
      (for [l (range 2 (inc (min n m)))
            :let [search (fn search [x cursq longpos]
                           (cond
                             (= l (count cursq)) (when (latin? cursq) #{cursq})
                             (< (count (vs x)) l) nil
                             :else (reduce clojure.set/union
                                     (if (and (= m (count (vs x))) longpos)
                                       [(search (inc x) (conj cursq (subvec (vs x) longpos (+ l longpos))) longpos)]
                                       (for [y (range (inc (- (count (vs x)) l)))]
                                         (search (inc x) (conj cursq (subvec (vs x) y (+ l y))) (or longpos y)))))))
                  latins (reduce clojure.set/union
                           (for [x (range (inc (- n l)))]
                             (search x [] nil)))]
            :when (not-empty latins)]
        [l (count latins)]))))

