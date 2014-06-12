; 117. For Science!
(fn [maze]
  (let [n (count maze)
        m (count (maze 0))
        find-c (fn [c]
                 (first (for [x (range n) y (range m) :when (= c (get-in maze [x y]))] [x y])))
        in-range (fn [[x y]]
                   (and (>= x 0) (>= y 0) (< x n) (< y m)))
        start (find-c \M)
        goal (find-c \C)
        dirs [[0 1] [0 -1] [1 0] [-1 0]]]
    (loop [q [start] reach #{start}]
      (println reach)
      (cond
        (reach goal) true
        (empty? q) false
        :else (let [exps (for [p q :when (not= \# (get-in maze p)) d dirs] (map + p d))
                    nexts (filter #(and (in-range %) (not (reach %))) exps)]
                (recur nexts (into reach nexts)))))))

