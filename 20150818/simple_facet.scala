val searcher = ISearcher("/tmp/index-brown")

searcher.search(rows=10000).map(_.getValue("cat").get(0)).
foldLeft(scala.collection.mutable.Map.empty[String, Int]){(m,c) => m += (c -> (m.getOrElse(c,0)+1))}.foreach(println(_))
