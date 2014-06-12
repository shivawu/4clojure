; 21. Nth Element
(fn [sq n]
  (loop [sq sq
         n n]
    (if (= n 0)
      (first sq)
      (recur (rest sq) (- n 1)))))
