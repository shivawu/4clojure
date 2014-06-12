; 66. Greatest Common Divisor
(fn [a b]
  (loop [a a b b]
    (if (zero? b)
      a
      (recur b (mod a b)))))

