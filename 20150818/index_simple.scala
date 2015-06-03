val CORPUS = Array(
  "Alice ate an apple.",
  "Mike likes an orange.",
  "An apple is red."
)

val index = "/tmp/index-simple"

def schema(): Schema = {
  val builder = AnalyzerBuilder()
  builder.withTokenizer("standard")
  builder.addTokenFilter("lowercase")
  val analyzer = builder.build
  val fieldTypes = Map(
    "text" -> FieldType(analyzer, true, true, true, true)
  )
  val analyzerDefault = analyzer
  Schema(analyzerDefault, fieldTypes)
}

def doc(text: String): Document = {
  Document(Set(
      Field("text", text)
    )
  )
}

val writer = IWriter(index, schema)

CORPUS.foreach(text => writer.write(doc(text)))

writer.close
