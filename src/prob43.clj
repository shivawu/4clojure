; 43. Reverse Interleave
(fn [s n]
  (map #(take-nth n (nthrest s (- % 1))) (range 1 (inc n))))

