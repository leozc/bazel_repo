
# https://docs.bazel.build/versions/master/be/workspace.html
workspace(name = "leozc_bazel")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

#########
# PYTHON
#########
# terrible second class support for python in bazel
http_archive(
    name = "rules_python",
    url = "https://github.com/bazelbuild/rules_python/releases/download/0.0.1/rules_python-0.0.1.tar.gz",
    sha256 = "aa96a691d3a8177f3215b14b0edc9641787abaaa30363a080165d06ab65e1161",
)
load("@rules_python//python:repositories.bzl", "py_repositories")
py_repositories()
# Only needed if using the packaging rules.
load("@rules_python//python:pip.bzl", "pip_repositories","pip_import")
pip_repositories()

pip_import(
    name = '3rdparty',
    requirements = '//:requirements.txt',
    #python_interpreter = 'xxx',
)
load("@3rdparty//:requirements.bzl", "pip_install")
pip_install()

#########
# SCALA
#########

# bazel-skylib (https://github.com/bazelbuild/bazel-skylib/releases/tag/1.0.2)
skylib_version = "1.0.2"
http_archive(
    name = "bazel_skylib",
    type = "tar.gz",
    url = "https://github.com/bazelbuild/bazel-skylib/releases/download/{}/bazel-skylib-{}.tar.gz".format (skylib_version, skylib_version),
    sha256 = "97e70364e9249702246c0e9444bccdc4b847bed1eb03c5a3ece4f83dfe6abc44",
)

rules_scala_version="a2f5852902f5b9f0302c727eead52ca2c7b6c3e2" # update this as needed

http_archive(
    name = "io_bazel_rules_scala",
    strip_prefix = "rules_scala-%s" % rules_scala_version,
    type = "zip",
    url = "https://github.com/bazelbuild/rules_scala/archive/%s.zip" % rules_scala_version,
    sha256 = "8c48283aeb70e7165af48191b0e39b7434b0368718709d1bced5c3781787d8e7",
)

load("@io_bazel_rules_scala//scala:toolchains.bzl", "scala_register_toolchains")
scala_register_toolchains()

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_repositories")
scala_repositories()

protobuf_version="3.11.3"
protobuf_version_sha256="cf754718b0aa945b00550ed7962ddc167167bd922b842199eeb6505e6f344852"

http_archive(
    name = "com_google_protobuf",
    url = "https://github.com/protocolbuffers/protobuf/archive/v%s.tar.gz" % protobuf_version,
    strip_prefix = "protobuf-%s" % protobuf_version,
    sha256 = protobuf_version_sha256,
)

load("@bazel_tools//tools/build_defs/repo:maven_rules.bzl", "maven_dependency_plugin")
maven_dependency_plugin()

#load("//3rdparty:workspace.bzl", "maven_dependencies")
#maven_dependencies()
#load("//3rdparty:target_file.bzl", "build_external_workspace")
#build_external_workspace(name = "third_party")

scala_repositories((
    "2.12.8",
    {
      "scala_compiler": "f34e9119f45abd41e85b9e121ba19dd9288b3b4af7f7047e86dc70236708d170",
      "scala_library": "321fb55685635c931eba4bc0d7668349da3f2c09aee2de93a70566066ff25c28",
      "scala_reflect": "4d6405395c4599ce04cea08ba082339e3e42135de9aae2923c9f5367e957315a",
    }
))

# end of scala support


#########
# JVM DEP
#########
# REF https://github.com/bazelbuild/rules_jvm_external
RULES_JVM_EXTERNAL_TAG = "3.0"
RULES_JVM_EXTERNAL_SHA = "62133c125bf4109dfd9d2af64830208356ce4ef8b165a6ef15bbff7460b35c3a"
http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    name = "default_maven",
    artifacts = [
        "junit:junit:4.12",
        "com.google.code.findbugs:jsr305:3.0.2",
        "com.google.errorprone:error_prone_annotations:2.0.18",
        "com.google.j2objc:j2objc-annotations:1.1",
    ],
    repositories = [
        # Private repositories are supported through HTTP Basic auth
       # "http://username:password@localhost:8081/artifactory/my-repository",
       # "https://jcenter.bintray.com/",
        "https://maven.google.com",
        "https://jcenter.bintray.com/",
        
    ],
    fetch_sources = True,
    # comment out the line below before ruuning `bazel run @default_maven//:pin`
    # run this to update     bazel run @unpinned_default_maven//:pin
    maven_install_json = "//:default_maven_install.json",
)
load("@default_maven//:defs.bzl", default_maven_pinned_maven_install ="pinned_maven_install")

default_maven_pinned_maven_install()

maven_install(
    name = "scala_maven",
    artifacts = [
        "org.apache.spark:spark-sql_2.12:2.4.5",
        "org.apache.spark:spark-core_2.12:2.4.5",
        "org.apache.spark:spark-tags_2.12:2.4.5",
        "org.apache.spark:spark-unsafe_2.12:2.4.5",
        "org.apache.spark:spark-catalyst_2.12:2.4.5",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
    #fetch_sources = True,
    # comment out the line below before ruuning `bazel run bazel run @scala_maven//:pin`
    # to update `bazel run @unpinned_scala_maven//:pin`
    maven_install_json = "//:scala_maven_install.json",
)

load("@scala_maven//:defs.bzl", scala_mave_pinned_maven_install = "pinned_maven_install")
scala_mave_pinned_maven_install()
# end of JVM support
