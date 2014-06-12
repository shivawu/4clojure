; 23. Reverse a Sequence
(fn [sq]
  (loop [orig sq
         res '()]
    (if (empty? orig)
      res
      (recur (rest orig) (cons (first orig) res)))))

