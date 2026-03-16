export function reloadPage(runtime = globalThis, force = false) {
  if (!force && process.env.NODE_ENV === "test") {
    return;
  }

  runtime.location.reload();
}