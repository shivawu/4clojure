; 94. Game of Life
(fn [board]
  (map (partial apply str)
    (let [n (count board)
          m (count (board 0))
          dirs [[0 1] [0 -1] [1 0] [-1 0] [-1 1] [1 -1] [-1 -1] [1 1]]
          cell (fn [board [x y]]
                 (-> board (nth x) (nth y)))
          live? (fn [board [x y]]
                  (and
                    (>= x 0) (>= y 0) (< x n) (< y m)
                    (= \# (cell board [x y]))))]
      (for [x (range n)]
        (for [y (range m)]
          (let [neibs (count (filter (partial live? board)
                               (map #(vec (map + [x y] %)) dirs)))
                next (if (live? board [x y])
                       (and (>= neibs 2) (<= neibs 3))
                       (= neibs 3))]
            (if next \# \space)))))))

