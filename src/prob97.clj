; 97. Pascal's Triangle
(fn pascal [n]
  (letfn [(comb [n k]
            (reduce #(/ (* %1 (+ %2 (- n k))) %2)
              1 (range 1 (inc k))))]
    (map (partial comb (dec n)) (range 0 n))))

