; 40. Interpose a Seq
(fn ip [x s]
  (cond
    (empty? s) ()
    (empty? (rest s)) (list (first s))
    :else (cons (first s) (cons x (ip x (rest s))))))

