#!/usr/bin/env bash
mvn versions:set -DnewVersion=$1
mvn package install
