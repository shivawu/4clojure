; 114. Global take-while
(fn take-while-n [n p coll]
  (if (empty? coll) nil
    (let [h (first coll)]
      (if (p h)
        (if (<= n 1) nil
          (cons h (take-while-n (dec n) p (rest coll))))
        (cons h (take-while-n n p (rest coll)))))))

