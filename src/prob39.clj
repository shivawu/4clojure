; 39. Interleave Two Seqs
(fn il [x y]
  (if (or (empty? x) (empty? y))
    ()
    (cons (first x) (cons (first y)
                      (il (rest x) (rest y))))))

