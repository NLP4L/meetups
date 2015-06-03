val index = "/tmp/index-simple"

val reader = RawReader(index)

val sum_words = reader.sumTotalTermFreq("text")

val uniq_words = reader.field("text").get.terms.size

val counts = reader.totalTermFreq("text", "an")

val ttdf = reader.topTermsByDocFreq("text")

val tttf = reader.topTermsByTotalTermFreq("text")

reader.close
