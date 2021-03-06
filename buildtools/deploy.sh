#!/bin/bash

DEPLOY_DIR=$1
VERSIONS=./versions

VERSION=$2

pushd $DEPLOY_DIR

file=$VERSIONS/NurseBot$VERSION.jar
models=$VERSIONS/activejdbc_models$VERSION.properties

if test ! -f $file; then
	echo "Version not found."
	exit 1
fi

unlink activejdbc_models.properties
ln $models activejdbc_models.properties

unlink NurseBot.jar
ln $file NurseBot.jar

popd
