// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorSimulateClickPlugin",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorSimulateClickPlugin",
            targets: ["SimulateClickPluginPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "SimulateClickPluginPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/SimulateClickPluginPlugin"),
        .testTarget(
            name: "SimulateClickPluginPluginTests",
            dependencies: ["SimulateClickPluginPlugin"],
            path: "ios/Tests/SimulateClickPluginPluginTests")
    ]
)