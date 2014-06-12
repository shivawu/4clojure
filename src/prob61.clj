; 61. Map Construction
(fn zm [ks vs]
  (when-let [ks (seq ks)]
    (when-let [vs (seq vs)]
      (into {(first ks) (first vs)} (zm (rest ks) (rest vs))))))

