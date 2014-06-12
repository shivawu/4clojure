; 56. Find Distinct Items
(fn [s]
  (reduce
    (fn [v x]
      (if (some #(= %1 x) v) v (conj v x)))
    []
    s))

