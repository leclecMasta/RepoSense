import reposense.git.CommitNotFoundException;
    private static final String SIMILAR_FILE_RENAMED_SYMBOL = "similarity index 100%\n";
        List<FileInfo> fileInfos = new ArrayList<>();

        try {
            GitChecker.checkoutToDate(config.getRepoRoot(), config.getBranch(), config.getUntilDate());
        } catch (CommitNotFoundException cnfe) {
            return fileInfos;
        }
            // file deleted, renamed, is binary file or is new and empty file, skip it
            if (fileDiffResult.contains(SIMILAR_FILE_RENAMED_SYMBOL) || fileDiffResult.contains(BINARY_FILE_SYMBOL)
                    || FILE_DELETED_PREDICATE.test(fileDiffResult) || NEW_EMPTY_FILE_PREDICATE.test(fileDiffResult)) {