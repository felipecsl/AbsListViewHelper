# Version 1.0.3

 * Updates dependencies and release to Maven Central.

# Version 1.0.2

 * Fixes helper when header view has height=match_parent or wrap_content. In this situation,
  getLayoutParameters().height would return a negative number which caused the header size
  measurement to fail. We now rely on OnGlobalLayoutListener instead and use smoothScrollBy
  to reset the scroll position.

# Version 1.0.1

 * Implements save/restore instance state to correctly store header/footer position
 * Fixes list/grid initial positioning not correctly displaying the header

# Version 1.0.0

Initial release!