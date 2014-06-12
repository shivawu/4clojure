; 98. Equivalence Classes
(fn [f d]
  (set (map #(into #{} %) (vals (group-by f d)))))

