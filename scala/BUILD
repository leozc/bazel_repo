load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_binary", "scala_test")
load("//3rdparty:foo.bzl", "var", "fct") 

scala_binary(
  name = "Hello",
  # seems bazel rule has some way to guess the start of the package based on prefix
  srcs = ["src/main/scala/com/foo/Hello.scala"],
  deps = [":HelloLib"],
  # runtime_deps,
  # data,
  main_class ="com.foo.Hello",
  # resources,
  # resource_strip_prefix,
  # scalacopts,
  # jvm_flags,
  # scalac_jvm_flags,
  # javac_jvm_flags,
  # unused_dependency_checker_mode
)




scala_library(
  name = "HelloLib",
  srcs = ["src/main/scala/com/foo/HelloLib.scala"],
  deps = [
  #  "//3rdparty/jvm/joda_time:joda_time"
  ],
  visibility = ["//:__pkg__"]
)

scala_binary(
  name = "SimpleSparkApp",
  # seems bazel rule has some way to guess the start of the package based on prefix
  srcs = ["src/main/scala/com/foo/SimpleSparkApp.scala"],
  deps = [":SimpleSparkApp_lib"],
  # runtime_deps,
  resources = ["README.md"],
  main_class ="com.foo.SimpleSparkApp"
  # resources,
  # resource_strip_prefix,
  # scalacopts,
  # jvm_flags,
  # scalac_jvm_flags,
  # javac_jvm_flags,
  # unused_dependency_checker_mode
)

scala_library(
  name = "SimpleSparkApp_lib",
  # seems bazel rule has some way to guess the start of the package based on prefix
  exports = [
    # turn `.` `-` to `_`
    "@scala_maven//:org_apache_spark_spark_sql_2_12",
    "@scala_maven//:org_apache_spark_spark_core_2_12",
    "@scala_maven//:org_apache_spark_spark_tags_2_12",
    "@scala_maven//:org_apache_spark_spark_unsafe_2_12",
    "@scala_maven//:org_apache_spark_spark_catalyst_2_12",
  ]
)


# scala_test(
#     name = "test-main",
#     srcs = ["src/test/scala/bazeltest/MainSpec.scala"],
#     deps = [":bazeltest"]
# )
