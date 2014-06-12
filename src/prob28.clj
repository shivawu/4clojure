; 28. Flatten a Sequence
(fn flat [x]
  (reduce concat
    (map #(if (sequential? %)
            (flat %) (list %)) x)))

