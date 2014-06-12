; 178. Best Hand
(fn [hand]
  (let [card (fn [[s r]]
               (let [suits {\D :diamond, \H :heart, \C :club, \S :spade}
                     ranks {\2 0, \3 1, \4 2, \5 3, \6 4, \7 5, \8 6, \9 7, \T 8,
                            \J 9, \Q 10, \K 11, \A 12}]
                 {:suit (suits s), :rank (ranks r)}))
        cards (map card hand)
        sfreq (frequencies (vals (frequencies (map :suit cards))))
        rfreq (frequencies (vals (frequencies (map :rank cards))))
        is-straight (let [[a b c d e] (sort (map :rank cards))]
                      (and (= b (inc a)) (= c (inc b)) (= d (inc c))
                        (or (= e (inc d)) (and (= a 0) (= e 12)))))]
    (cond
      (and is-straight (sfreq 5)) :straight-flush
      (rfreq 4) :four-of-a-kind
      (and (rfreq 3) (rfreq 2)) :full-house
      (sfreq 5) :flush
      is-straight :straight
      (rfreq 3) :three-of-a-kind
      (= 2 (rfreq 2)) :two-pair
      (rfreq 2) :pair
      :else :high-card)))
