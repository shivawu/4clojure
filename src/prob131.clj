; 131. Sum Some Set Subsets
(fn [& s]
  (let [power-set (fn [s]
                    (reduce (fn [s x] (into s (map #(conj % x) s))) #{#{}} s))
        sums #(set (map (partial apply +) (disj % #{})))]
    (not (empty? (reduce clojure.set/intersection (map (comp sums power-set) s))))))

