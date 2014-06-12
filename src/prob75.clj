; 75. Euler's Totient Function
(fn [n]
  (letfn [(gcd [a b]
            (loop [a a b b]
              (if (zero? b) a (recur b (mod a b)))))]
    (count (filter #(= 1 (gcd n %)) (range 1 (inc n))))))

