; 67. Prime Numbers
(fn [c]
  (take c
    ((fn sieve [n]
       (cons n
         (lazy-seq (remove #(= 0 (mod % n)) (sieve (inc n)))))) 2)))

