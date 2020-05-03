#!/bin/bash
bazel test $(bazel query //...)
