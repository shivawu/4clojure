; 137. Digits and bases
(fn self [n b]
  (if (zero? n) '(0)
    (loop [n n acc '()]
      (if (zero? n) acc
        (recur (quot n b) (cons (mod n b) acc))))))

