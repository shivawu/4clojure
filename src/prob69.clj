; 69. Merge with a Function
(fn [f & maps]
  (let [merge-into (fn [m e]
                     (let [k (key e) v (val e)]
                       (if (contains? m k)
                         (assoc m k (f (get m k) v))
                         (assoc m k v))))
        merge-map (fn [m1 m2]
                    (reduce merge-into m1 m2))]
    (reduce merge-map maps)))

