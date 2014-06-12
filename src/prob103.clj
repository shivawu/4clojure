; 103. Generating k-combinations
(fn kcomb [n s]
  (cond
    (> n (count s)) #{}
    (zero? n) #{#{}}
    :else (into
            (kcomb n (rest s))
            (map #(conj % (first s)) (kcomb (dec n) (rest s))))))

