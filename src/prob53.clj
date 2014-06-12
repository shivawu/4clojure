; 53. Longest Increasing Sub-Seq
(fn [s]
  (loop [x s fw [] best []]
    (cond
      (empty? x) best
      (and (not-empty fw) (= (inc (last fw)) (first x))) (let [nfw (conj fw (first x))]
                                                           (if (> (count nfw) (count best))
                                                             (recur (rest x) nfw nfw)
                                                             (recur (rest x) nfw best)))
      :else (recur (rest x) [(first x)] best))))

