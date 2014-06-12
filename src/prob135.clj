; 135. Infix Calculator
(fn [& ops]
  (if (= 1 (count ops))
    (first ops)
    (let [[x op y & rest] ops]
      (recur (cons (op x y) rest)))))

