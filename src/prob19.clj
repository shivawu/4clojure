; 19. Last Element
(fn [x] (loop [x x] (if (empty? (rest x)) (first x) (recur (rest x)))))

