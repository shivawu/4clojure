; 119. Win at Tic-Tac-Toe
(fn [p board]
  (let [win? (fn [[[a b c] [d e f] [g h i]] p]
               (or (= p a b c)
                 (= p d e f)
                 (= p g h i)
                 (= p a d g)
                 (= p b e h)
                 (= p c f i)
                 (= p a e i)
                 (= p c e g)))]
    (set
      (for [x (range 3) y (range 3)
            :when (= :e (get-in board [x y]))
            :when (win? (assoc-in board [x y] p) p)]
        [x y]))))

