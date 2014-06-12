; 65. Black Box Testing
(fn [coll]
  (cond
    (= 1 (count (conj (empty coll) [1 2] [1 3]))) :map (= 1 (count (conj (empty coll) 1 1))) :set (= 2 (first (conj (empty coll) 1 2))) :list :else :vector))

