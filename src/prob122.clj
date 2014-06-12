; 122. Read a binary number
(fn [bin]
  (reduce (fn [x y]
            (+ x x (- (int y) 48)))
    0 bin))

