```
com.dragome.web.helpers.serverside.StandaloneDragomeAppGenerator::execute()
  copyResources() : CSS, JavaScript resource をコピー
  compile()
    theConfiguredURLs : compile の classpath に含まれる directory, jar の一覧
    com.dragome.services.serverside.ServerReflectionServiceImpl::getConfigurator()
      com.dragome.commons.DragomeConfiguratorImplementor annotation を検索
        com.badlogic.gdx.backends.dragome.DragomeConfiguration が configurator として選択される (priority が高い)
          注意：webapp のパスが / ではなく \ になっているが大丈夫らしい
          gdx から assets を抽出して webapp/assets にコピー
          classpathFilter を定義している
    serviceLocator.getConfigurator().filterClassPath(theClassPathEntry) : theConfiguredURLs をフィルタ
      LearningGDX/html/build/classes/main
      repository/com/badlogicgames/gdx/gdx/1.9.5/gdx-1.9.5.jar
      repository/com/dragome/dragome-web/0.96-beta4/dragome-web-0.96-beta4.jar
      repository/com/dragome/dragome-w3c-standards/0.96-beta4/dragome-w3c-standards-0.96-beta4.jar
      repository/com/dragome/dragome-js-jre/0.96-beta4/dragome-js-jre-0.96-beta4.jar
      repository/gdx-backend-dragome/gdx-backend-dragome/0.0.1-SNAPSHOT/gdx-backend-dragome-0.0.1-SNAPSHOT.jar
      repository/com/dragome/dragome-js-commons/0.96-beta4/dragome-js-commons-0.96-beta4.jar
      repository/com/dragome/dragome-core/0.96-beta4/dragome-core-0.96-beta4.jar
    com.dragome.web.helpers.serverside.DragomeCompilerLauncher::compileWithMainClass()
      classPath = フィルタされた classPath, target = "build/dragome/compiled-js"
      process()
        classpathEntry.copyFilesToJar(jar, classpathFileFilter)
          com.dragome.commons.compiler.classpath.serverside::getClasspathFilesFiltering()
            classPath に含まれるファイルを jar ファイルにコピー (dragome-merged-[0-9]+.jar)
        configurator.isRemoveUnusedCode() == true ならば runProguard()
          dragome-merged-[0-9]+-proguard.jar
          BUG: 必要なファイルを除去、別途クラス追加しているためと思われる
        classPath は上記 jar に configurator から取得した extraClasspath が加えられる
        compilerConfiguration = new BytecodeToJavascriptCompilerConfiguration
        com.dragome.compiler.DragomeJsCompiler
          configure(compilerConfiguration)
          compile()
            execute(Assembly)
              classPath のクラスについて com.dragome.compiler.Project::createClassUnit()
                classByName に className : classUnit のペアを保存
                477 ファイル -> 383 エントリー
              classPath のクラスについて com.dragome.compiler.writer.Assembly::resolveNoTainting()
                com.dragome.compiler.type.TypeResolver::visit()
                  compile()
                  classByName.get で null が返ってきて失敗する
```

```
className="org.anyspirit.learning.gdx.MyGdxGame"
annotationClassName="kotlin.Metadata"
annotationKey="::::d1" (d1 : Array<String>)
annotationValue="\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081\u0002\u0018\u00002\u00020\u0001BR\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003R\t\u0010\u0006\u001a\u00020\u0005¢\u0006\u0000R\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0000R\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0000R\t\u0010\u0002\u001a\u00020\u0003¢\u0006\u0000R\t\u0010\u0004\u001a\u00020\u0005¢\u0006\u0000R\t\u0010\f\u001a\u00020\u0003¢\u0006\u0000R\t\u0010\u000b\u001a\u00020\t¢\u0006\u0000¨\u0006\r"

Constant::readConstant でバイトコードを読む
13 = CONSTANT_Utf8[1]("  \n\n\n\n\n \n\n \n\n 20B¢J0HJ	0HJ\n0HR0X.¢\n R0X.¢\n ¨")
```
