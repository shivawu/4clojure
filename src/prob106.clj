; 106. Number Maze
(fn [s t]
  (loop [q [s] d #{s} c 1]
    (if (d t) c
      (let [expand (fn [x]
                     [(* 2 x) (+ 2 x) (when (even? x) (/ x 2))])
            nexts (remove d (filter identity (mapcat expand q)))]
        (recur nexts (into d nexts) (inc c))))))

