when 'READY TO TEST', {
    'success' should: 'DONE'
}

when 'DONE', {
    'failure' should: 'REOPENED'
}

when 'REOPENED', {
    'success' should: 'DONE'
}



when 'READY TO TEST', {
     'failure' should: 'REOPENED'
}

when 'READY TO TEST', {
     'error' should: 'REOPENED'
}
