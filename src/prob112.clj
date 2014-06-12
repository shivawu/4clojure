; 112. Sequs Horribilis
(comp first
  (fn _ [sum coll]
    (if (or (< sum 0) (empty? coll))
      ['() 0]
      (let [h (first coll) t (rest coll)]
        (if (integer? h)
          (if (<= h sum)
            (let [[x y] (_ (- sum h) t)]
              [(cons h x) (+ y h)])
            ['() 0])
          (let [[x y] (_ sum h)
                [a b] (_ (- sum y) t)]
            [(cons x a) (+ y b)]))))))

