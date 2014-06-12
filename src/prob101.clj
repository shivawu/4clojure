; 101. Levenshtein Distance
(let [edit-dis (fn [self s t]
                 (cond
                   (empty? s) (count t)
                   (empty? t) (count s)
                   :else (let [r1 (inc (self self s (rest t)))
                               r2 (inc (self self (rest s) t))
                               r3 (self self (rest s) (rest t))]
                           (if (= (first s) (first t))
                             (min r1 r2 r3)
                             (min r1 r2 (inc r3))))))
      edit-dis-m (memoize edit-dis)]
  (partial edit-dis-m edit-dis-m))

