import Foundation
import WebKit
import AppKit

let app = NSApplication.shared

class PDFMaker: NSObject, WKNavigationDelegate {
    let webView: WKWebView
    var finished = false
    
    override init() {
        let config = WKWebViewConfiguration()
        config.websiteDataStore = WKWebsiteDataStore.nonPersistent()
        webView = WKWebView(frame: NSRect(x: 0, y: 0, width: 800, height: 1100), configuration: config)
        super.init()
        webView.navigationDelegate = self
    }
    
    func generate(html: String, output: URL) {
        webView.loadHTMLString(html, baseURL: Bundle.main.bundleURL)
        
        let runLoop = RunLoop.current
        while !finished && runLoop.run(mode: .default, before: Date(timeIntervalSinceNow: 0.1)) {
        }
    }
    
    func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        let printInfo = NSPrintInfo()
        printInfo.paperSize = NSSize(width: 595.28, height: 841.89) // A4
        printInfo.topMargin = 20
        printInfo.bottomMargin = 20
        printInfo.leftMargin = 20
        printInfo.rightMargin = 20
        printInfo.isHorizontallyCentered = false
        printInfo.isVerticallyCentered = false
        printInfo.jobDisposition = .save
        printInfo.dictionary().setObject(URL(fileURLWithPath: "wk_print_test.pdf"), forKey: NSPrintInfo.AttributeKey.jobSavingURL as NSCopying)
        
        let printOp = webView.printOperation(with: printInfo)
        printOp.showsPrintPanel = false
        printOp.showsProgressPanel = false
        let success = printOp.run()
        print("PrintOp run success: \(success)")
        self.finished = true
    }
}

let maker = PDFMaker()
let html = """
<html>
<head>
<style>
@page { size: A4; margin: 15mm; }
body { font-family: -apple-system, sans-serif; }
.p1 { height: 700px; background: #e0f2fe; padding: 20px; }
.p2 { height: 700px; background: #fef08a; padding: 20px; page-break-before: always; }
</style>
</head>
<body>
<div class="p1"><h1>1페이지입니다</h1></div>
<div class="p2"><h1>2페이지입니다</h1></div>
</body>
</html>
"""
maker.generate(html: html, output: URL(fileURLWithPath: "wk_print_test.pdf"))

