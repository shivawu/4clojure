; 73. Analyze a Tic-Tac-Toe Board
(fn [board]
  (letfn [(win [[[a b c] [d e f] [g h i]] p]
            (or (= p a b c)
              (= p d e f)
              (= p g h i)
              (= p a d g)
              (= p b e h)
              (= p c f i)
              (= p a e i)
              (= p c e g)))]
    (cond
      (win board :x) :x (win board :o) :o :else nil)))

