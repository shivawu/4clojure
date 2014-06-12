; 148. The Big Divide
(fn [n a b]
  (let [div-sum (fn [n k]
                  (let [c (bigint (quot n k))]
                    (quot (* k c (inc c)) 2)))]
    (+
      (div-sum (dec n) a)
      (div-sum (dec n) b)
      (- (div-sum (dec n) (* a b))))))

