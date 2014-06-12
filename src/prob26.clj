; 26. Fibonacci Sequence
(fn [n]
  (case n
    (1) '(1)
    (2) '(1 1)
    (reverse
      (loop [n (- n 2)
             sq '(1 1)]
        (if (= n 0)
          sq
          (recur (- n 1) (cons (+ (first sq) (first (rest sq))) sq)))))))

