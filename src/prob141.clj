; 141. Tricky card games
(fn [trump]
  (fn [cards]
    (loop [[{s :suit, r :rank :as c} & cs :as css] (rest cards)
           winner (first cards)
           lead (:suit (first cards))]
      (if (empty? css) winner
        (recur
          cs
          (if (or
                (and (= s trump) (or (not= (:suit winner) trump) (> r (:rank winner))))
                (and (not= s trump) (not= (:suit winner) trump) (= s lead) (> r (:rank winner)))) c winner)
          lead)))))

