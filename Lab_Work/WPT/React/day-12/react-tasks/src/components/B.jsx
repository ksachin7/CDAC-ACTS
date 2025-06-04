import React from 'react';
import C from './C';
import A from './A'; // for (d) circular use

function B() {
  return (
    <div>
      <h3>Component B</h3>
      {/* <C /> */} {/* used for (a) or (d) */}
      {/* <A /> */} {/* for (d) */}
    </div>
  );
}
export default B;
