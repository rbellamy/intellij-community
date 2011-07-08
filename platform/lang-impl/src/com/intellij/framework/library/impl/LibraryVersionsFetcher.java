/*
 * Copyright 2000-2011 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.framework.library.impl;

import com.intellij.facet.frameworks.beans.Artifact;
import com.intellij.util.download.DownloadableFileDescription;
import com.intellij.framework.library.DownloadableLibraryDescription;
import com.intellij.framework.library.FrameworkLibraryVersion;
import com.intellij.util.download.impl.FileSetVersionsFetcherBase;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.List;

/**
 * @author nik
 */
public class LibraryVersionsFetcher extends FileSetVersionsFetcherBase<FrameworkLibraryVersion> implements DownloadableLibraryDescription {

  public LibraryVersionsFetcher(@NotNull String groupId, @NotNull URL[] localUrls) {
    super(groupId, localUrls);
  }

  @Override
  protected FrameworkLibraryVersion createVersion(Artifact version, List<DownloadableFileDescription> files) {
    return new FrameworkLibraryVersionImpl(version.getVersion(), files, myGroupId, null);
  }
}
