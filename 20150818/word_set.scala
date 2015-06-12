val reader = RawReader("/tmp/index-ldcc")

val ds1 = reader.subset(TermFilter("cat", "dokujo-tsushin"))
val ds2 = reader.subset(TermFilter("cat", "sports-watch"))

val ws1 = WordCounts.count(reader, "body", Set.empty[String], ds1, -1, null).toSet
val ws2 = WordCounts.count(reader, "body", Set.empty[String], ds2, -1, null).toSet

ws1 &~ ws2  // jargon of dokujo-tsushin
ws2 &~ ws1  // jargon of sports-watch
ws1 & ws2   // stop words

reader.close
